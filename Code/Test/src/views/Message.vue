<template>
    <div class="div1">
        <h1>我是Message的控制界面</h1>
        <RouterLink :to="loginParam">login</RouterLink>
        <RouterLink :to="registerParams">register</RouterLink>
        <RouterView />
        
    </div>
</template>

<script setup>
    import { RouterLink, RouterView } from 'vue-router'
    import {ref,reactive} from 'vue'


    const queryParam = reactive({id:1,email:"166@qq.com"})
    // path:匹配配置路由的path值，显示对应的
    const loginParam = reactive({path:'/message/login',query:queryParam})
    const params = reactive({name:"张三",id:2})
    // name:表示路由的名称，params:{配置路由时，占位参数的名称：值}
    const registerParams = reactive({name:"register",params})
</script>

<style scoped>
    .div1{
        width:400px;
        height:400px;
        background-color: blueviolet;
    }
</style>