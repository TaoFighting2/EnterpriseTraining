<template>
    <!-- <div>
        <button type="button" @click="down">上一页</button>
        <input type="text" class="text1" :class="[active === 1 ? 'bgcolor' : '']" disabled value="1">
        <input type="text" class="text1" :class="[active === 2 ? 'bgcolor' : '']" disabled value="2">
        <input type="text" class="text1" :class="[active === 3 ? 'bgcolor' : '']" disabled value="3">
        <input type="text" class="text1" :class="[active === 4 ? 'bgcolor' : '']" disabled value="4">
        <input type="text" class="text1" :class="[active === 5 ? 'bgcolor' : '']" disabled value="5">
        <input type="text" class="text1" :class="[active === 6 ? 'bgcolor' : '']" disabled value="6">
        <button type="button" @click="up">下一页</button>
        跳转到：<input type="text" on-model="page">页
        <button type="button" @click="go">Go</button>

    </div> -->
    <div class="btn-box">
         {{ psize + 1 }}
    </div>

</template>

<script setup>
    import {reactive,ref,toRefs} from 'vue';
    const active = ref(1)
    import { defineProps } from 'vue';
    const sizeProps = defineProps(['size'])
    //将传过来的参数变为响应式参数
    console.log(typeof sizeProps)
    console.log(sizeProps)
    const psize = sizeProps.size
</script>

<style scoped>

    .text1{
        height:20px;
        width:20px
    }
    .bgcolor{
        background-color: fuchsia;
    }


    .btn-box{
        width:30px;
        height:25px;
        /* background-color: #ddd; */
    }

</style>