<script setup>
import ComponentsA from '@/components/ComponentsA.vue';
import ComponentsB from '@/components/ComponentsB.vue';
import Btn from '@/components/Btn.vue';
import {ref} from 'vue'
const postTitle = ref("父组件的postTitle")
const otherTitle = ref("父组件的otherTitle")
// import TheWelcome from '../components/TheWelcome.vue'

//回调函数
const callBack = (data) => {
  console.log("data=",data)
}
</script>

<template>
  <main>
    <!-- <TheWelcome /> -->
     <!-- 通过属性绑定方式，把父组件的变量的值传入子组件 -->
      <!-- 绑定的属性名 -->
    <ComponentsB :postTitle="postTitle" :otherTitle="otherTitle"></ComponentsB>
    <ComponentsA @itemClick="callBack" @itemTest="callBack"></ComponentsA>
    <Btn></Btn>
  </main>
</template>

