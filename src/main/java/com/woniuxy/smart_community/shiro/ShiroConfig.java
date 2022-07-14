package com.woniuxy.smart_community.shiro;/**
 * @description: TODO
 * @author 李佳复
 * @date 2022/7/1 12:05
 * @version 1.0
 */

import org.apache.shiro.mgt.SessionStorageEvaluator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSessionStorageEvaluator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 李佳复  <br/>
 * Date: 2022/7/1:12:05  <br/>
 * Description:
 */
@Configuration
public class ShiroConfig {
    /*/*
     * Description : 配置securityManager，因为我们要自定义JWT方式进行认证！
     *    把自定义域交给securityManager来进行管理和使用！  <br/>
     * ChangeLog : 1. 创建 (2022/7/1 12:05 [58369]);
     ** @param null
     * *  @return null
     */

    @Bean
    public DefaultWebSecurityManager securityManager(MyRealm mrRealm) {
        //解决域使用异常问题， mrRealm.setAuthenticationTokenClass(MyJsonWebToken.class);
        mrRealm.setAuthenticationTokenClass(MyJsonWebToken.class);
        return new DefaultWebSecurityManager(mrRealm);
    }
    /*/*
     * Description : 配置过滤器工厂，使用我们写的JWTFilter生效！以及过滤条件和拦截url配置！  <br/>
     * ChangeLog : 1. 创建 (2022/7/1 12:08 [58369]);
     ** @param null
     * *  @return null
     */

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        //创建过滤器工厂bean
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置securityManager
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String, Filter> filters = new HashMap<>();
        filters.put("JWT", new JWTFilter());
        //把我们写的filter放入shiro的过滤器工厂bean中，然后交给spring来管理！
        shiroFilterFactoryBean.setFilters(filters);
        //什么时候触发使用你的JWT过滤器
        //FilterChain 我们所有的权限框架都是基于一堆过滤器链来实现的！
        Map<String, String> filterChainDefinitionMap = new HashMap<>();
        //从上往下按顺序过滤
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/401", "anon");
        filterChainDefinitionMap.put("/**", "JWT");
        //这个配置 推荐使用注解来生效！
//        filterChainDefinitionMap.put("/rbacManager/**", "authc");
        //anon 是匿名访问 除此之外还有个常用的 authc 需要认证！

        //这个是用来设置过滤器链使用的条件的！
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
    /*/*
     * Description : 禁用session, 不保存用户登录状态。保证每次请求都重新认证。
     * 需要注意的是，如果用户代码里调用Subject.getSession()还是可以用session  <br/>
     * ChangeLog : 1. 创建 (2022/7/1 12:08 [58369]);
     ** @param null
     * *  @return null
     */

    @Bean
    protected SessionStorageEvaluator sessionStorageEvaluator() {
        DefaultWebSessionStorageEvaluator sessionStorageEvaluator = new DefaultWebSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(false);
        return sessionStorageEvaluator;
    }
    /*/*
     * Description : 开启shiro注解支持  <br/>
     * ChangeLog : 1. 创建 (2022/7/1 12:08 [58369]);
     ** @param null
     * *  @return null
     */

    @Bean
    public AuthorizationAttributeSourceAdvisor
    authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new
                AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
    /*/*
     * Description : 管理Subject主体对象,生命周期的组件,
     *用户只是打印下生产销毁日志什么的,请参考spring中bean的生命周期  <br/>
     * ChangeLog : 1. 创建 (2022/7/1 12:07 [58369]);
     ** @param null
     * *  @return null
     */

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}
