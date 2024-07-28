<template>
  <div class="div1">
    <h2>{{ title }}</h2>
  </div>
</template>

<script setup>
    import {onMounted, onUpdated, ref} from 'vue'
    import {useRoute} from 'vue-router'
    const title = ref('我是注册页面')
    const route = useRoute()
    onMounted(()=>{
      // console.log('output-->route',route)
      // console.log('output-->route.query',route.params)
      // console.log('output-->route.query.id',route.params.name)
      // console.log('output-->route.query.email',route.params.id)
      console.log("Register is success")
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