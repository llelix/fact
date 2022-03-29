package com.facto.configuration;


import com.facto.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 用户认证
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());//使用BCryptPasswordEncoder进行加密
    }



    /**
     * 基于json用户登录判断及响应
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()//所有的路径都是登录后即可访问
                .and().formLogin().loginPage("/doLogin")//如果是未登录的会自动跳到该接口（根据需要自己实现，返回页面或返回json）
                .loginProcessingUrl("/login")//发起登录请求的接口
                .usernameParameter("username")//设置登录请求接口的参数（用户名）
                .passwordParameter("password")//设置登录请求接口的参数（密码）
                .permitAll()
                .and()
                .logout()//注销登录接口（/logout）
                .logoutUrl("/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {//注销成功时的处理
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();
                        out.write("注销成功");
                        out.flush();
                        out.close();
                    }
                })
                .permitAll().and().csrf().disable().exceptionHandling()
                .accessDeniedHandler(getAccessDeniedHandler());//用户权限不足时的处理

        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    /**
     * 自定义security过滤器，以实现用post发起登录请求时，参数用json传递
     * @return
     * @throws Exception
     */
    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();

        /**登录成功**/
        filter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.write("{\"status\":\"success\",\"msg\":\"登录成功\"}");
                out.flush();
                out.close();
            }
        });

        /**登录失败**/
        filter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.write("{\"status\":\"error\",\"msg\":\"登录失败！！\"}");
                out.flush();
                out.close();
            }
        });


        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    /**
     * 用户权限不足时的处理
     *
     * @return
     */
    @Bean
    AccessDeniedHandler getAccessDeniedHandler() {
        return new AuthenticationAccessDeniedHandler();
    }

}

