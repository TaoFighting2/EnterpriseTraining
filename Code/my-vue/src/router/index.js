import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import MainView from '@/views/MainView.vue'
import LoginView from '@/views/LoginView.vue'
import RegisterView from '@/views/RegisterView.vue'

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
      path:'/parentA',
      name:'parentA',
      component:() => import('../views/ParentViewA.vue')
    },
    {
      path:'/Main',
      name:'Main',
      component:MainView
    },
    {
      path:'/message',
      name:'message',
      component:()=> import('../views/Message.vue'),
      children: [
        {
          // 嵌套路径一定要先写父路径再写子路径
          path:'/message/login',
          name:'login',
          component:LoginView
        },
        {
          path:'/message/register/:name/:id',
          name:'register',
          component:RegisterView
        }
      ]
    },
    {
      path:'/pageBtn/product',
      name:'product',
      component:()=>import('../views/pageBtn/Product.vue')
    }
  ]
})

export default router
