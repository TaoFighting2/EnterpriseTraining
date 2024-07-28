import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path:'/parent',
      name:'parent',
      component: () => import('../views/Parent.vue')
    },
    {
      path:'/message',
      name:'message',
      component: () => import('../views/Message.vue'),
      children:[
        {
          path:'/message/login',
          name:'login',
          component: () => import('../views/login.vue')
        },
        {
          path:'/message/register/:id/:name',
          name:'register',
          component: () => import('../views/register.vue')
        }
      ]
    }
  ]
})

export default router
