<!--
    父传子数据，单向的数据流
-->
<
<template>
    <div>
        <h1>{{info}}</h1>
        <h2>{{postTitle}}</h2>
        <h2>{{otherTitle}}</h2>
        <ul>
            <li v-for="item in arr">{{item}}</li>
        </ul>
        <button type="button" @click="show">传值</button>
    </div>
</template>

<script setup>
    import {ref,defineProps} from'vue'
    const info = ref('组件B')
    const arr = ref([10,20,30])
    // 调用defineprops函数，传进来一个数组，数组中的字符串（理解成变量）
    //      就是用来接收父组件的传值
    //定义时使用驼峰命名法
    //definProps函数的返回值，就是代理对象
    const objProps = defineProps(['postTitle','otherTitle'])
    const show = ()=>{
        console.log(`output-->objProps`,objProps)
        console.log(`output-->objProps.postTitle`,objProps.postTitle)
        console.log(`output-->objProps.otherTitle`,objProps.otherTitle)
    }
</script>

<style>

</style>

