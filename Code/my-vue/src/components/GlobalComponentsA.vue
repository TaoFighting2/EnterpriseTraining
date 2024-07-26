<!-- 模板 写HTML标签 用来显示用 -->
<template>
  <h1>{{info}}</h1>
  <a href="http://www.baidu.com">百度</a>
  <br>
  <button type="button" @click="changeInfo">修改Info</button>
</template>

<!-- 写逻辑和定义变量 -->
<script setup>

    import {ref} from 'vue'
    const info = ref('今天天气不错')
    const changeInfo = ()=>{
        info.value = "没下雨"
    }

</script>

<!-- 语法糖scoped:表示样式是局部的，保证独立性，只对当前页面有效 -->
<style scoped>

</style>