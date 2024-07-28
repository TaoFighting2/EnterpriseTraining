<script setup>
import ComponentA from '@/components/ComponentA.vue';
import ComponentB from '@/components/ComponentB.vue';
import {reactive, ref} from 'vue'
const arr = ref(["jyt","jhl"])
const recive = (data)=>{
  console.log("传过来的数据",data);
}
</script>

<template>
  <div class="about">
    <h1>This is an about page</h1>
    <ComponentA :item="arr"></ComponentA>
    <ComponentB @ClickB="recive"></ComponentB>
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
