<template>
  <div>
        <!-- 作用域插槽：父组件替换插槽的标签，但是内容由子组件决定，
        作用域插槽可以理解为带有数据的插槽 -->
    <div style="color: blueviolet;background-color:aquamarine">
        <slot name="header" :headerData="hData"></slot>
    </div>
    <slot :bodyData="objData"></slot>
    <slot name="footer" :footerData="fData"></slot>
  </div>
</template>

<script setup>
    import {reactive,defineProps} from 'vue'

    const hData = reactive([10,20,30])
    const fData = reactive(['A','B','C'])
    const objData = reactive({
        userName : "zhangsan",
        password : '123456'
    })
</script>
