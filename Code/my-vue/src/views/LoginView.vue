<template>
    <div class="div1">
      <h2>{{ title }}</h2>
    </div>
</template>

<script setup>
    import {ref,onMounted} from 'vue'
    import {useRoute} from 'vue-router'
    const title = ref('我是登录页面')
    // 执行useRoute函数获取返回值对象
    const route = useRoute()
    onMounted(()=>{
      //获取url(path)传过来的参数
    //  console.log(`output--route.query`,route.query)
    //  console.log('output--route.query.id',route.query.id)
    //  console.log('output--route.query.email',route.query.email)
      console.log("Login is success")
    })
</script>

<style scoped>
    .div1{
        width:300px;
        height:300px;
        border: 2px solid black;
        background-color: blue;
    }
</style>