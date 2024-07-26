
<!-- setup是一个语法糖
  作用：1.把script标签内定义的常量，变量，函数（方法）编译到setup函数的体内，
  并全部暴露出去。
      2.生成组件（Vue对象）的名称就是文件的名称，组件时一个页面的功能
-->

<script setup>
  import {ref} from 'vue'
  import GlobalComponentsA from '@/components/GlobalComponentsA.vue';
  // export default{}默认导出一个对象（组件，也就是Vue对象）

  //定义一个常量或者变量
  const msg = ref("hello vue")
  const change = ()=>{
    msg.value="TaoFighting2到此一游"
  }
</script>

<template>
  <div class="about">
    <h1>This is an about page</h1>
    <h1>{{ msg }}</h1>
    <button type="button" @click="change">修改</button>
    <!-- 使用组件 跟html标签一样使用组件 -->
     <!-- 驼峰命名法，使用时驼峰和短横杠写法都可以 -->
      <!-- 单双都可以，脚手架环境；不在脚手架环境，单标签只能使用一次 -->
    <GlobalComponentsA></GlobalComponentsA>
    
  </div>
</template>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
