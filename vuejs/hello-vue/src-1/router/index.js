import Vue from 'vue'
import Router from 'vue-router'

import Main from '../views/Main'
import Login from '../views/Login'
import NotFound from '../views/404'

import UserProfile from '../views/user/Profile'
import UserList from '../views/user/List'

import VueResource from "../views/test/VueResource";

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/main/:name',
      component: Main,
      props: true,
      //嵌套路由
      children: [
        {path: '/user/list',component: UserList},
        {path: '/user/profile/:id/:no',name: 'UserProfile',component: UserProfile},
        {path: '/test/vueresource/:no',name:'VueResource',component: VueResource},
      ]
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/goHome',
      redirect: '/main'//重定向
    },
    {
      path: '*',
      component: NotFound
    }
  ]
});
