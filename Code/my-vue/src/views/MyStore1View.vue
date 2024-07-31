<template>
    <div class="div1">
        <div>从state上获取的count：{{ count }}</div>
        <div>从state上获取的data：{{ data }}</div>
        <div>从getters上获取的getCount：{{ userStore.getCount }}</div>
        <button @click="add">+1</button>
        <button @click="sub">-1</button>
    </div>
</template>

<script setup>
    import { useUserStore } from '@/stores/user';
    import { storeToRefs } from 'pinia';// 用来进行响应式解构

    const userStore = useUserStore()
    // storeToRefs保持响应式解构
    // 将 pinia 中的 store 对象中的状态转换为具有 .value 的 ref 对象集合
    const {count,data} = storeToRefs(userStore)
    const sub = () => {
        userStore.subCount(1)
    }
    const add = () => {
        userStore.addCount(1)
    }


</script>

<style scoped>
    .div1{
        border:1px solid #0000ff;
    }
</style>