<template>
  <div class="div1">
    <h1>{{ info }}</h1>
  </div>
</template>

<script setup>
    import {ref} from 'vue'
    const info = ref('我是main')
</script>

<style scoped>
    .div1{
        width:200px;
        height:200px;
        color: brown;
        background-color: beige;
    }
</style>