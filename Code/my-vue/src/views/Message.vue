 <!--
    * @FileDescription: vue嵌套路由第一次尝试
    * @Author: TaoFighting2
    * @email: 1665636918@qq.com
    * @Date: 2024年7月27日
 -->


<script setup>

import { RouterLink, RouterView } from 'vue-router'
import {reactive,ref} from 'vue'
const title = ref('消息')
const queryParam = reactive({id:1,email:"166@qq.com"})
// path:匹配配置路由的path值，显示对应的
const loginParam = reactive({path:'/message/login',query:queryParam})
// const registerParam = reactive({path:'/message/register',query:queryParam})
const params = reactive({name:"张三",id:2})
// name:表示路由的名称，params:{配置路由时，占位参数的名称：值}
const registerParams = reactive({name:"register",params})

</script>

<template>
        <div class="div1">
            <h1>TaoFighting2的第一个路由案例</h1>
            <RouterLink :to="loginParam">login</RouterLink>
            <!-- name:表示路由的名称，params:{配置路由时，占位参数的名称：值} -->
            <RouterLink :to="registerParams">register</RouterLink>
            <!-- <div> -->
            <RouterView />
             <!-- </div> -->
        </div>
</template>

<style scoped>
      .div1{
          width:400px;
          height:400px;
          background-color: blueviolet;
      }
</style>
