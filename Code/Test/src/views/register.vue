<template>
  <div class="div1">
    <h1>我是注册页面</h1>
  </div>
</template>

<script setup>

    import {ref,reactive,onMounted} from 'vue'
    import {useRoute} from 'vue-router'
    const r=useRoute()
    onMounted(()=>{
        console.log("register is success ",r)
        console.log(r.params)
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