import Vue from 'vue'
import Router from 'vue-router'

import main from '../views/Main'
import error from '../views/404'

import Group1Option1 from '../views/group1/Option1'
import Group1Option2 from '../views/group1/Option2'

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/main',
      component: main,
      children: [
        {path: '/group1/option1',component: Group1Option1},
        {path: '/group1/option2',component: Group1Option2},
      ]
    },
    {
      path: '/',
      redirect: '/main'
    },
    {
      path: "*",
      component: error
    }

  ]
});
