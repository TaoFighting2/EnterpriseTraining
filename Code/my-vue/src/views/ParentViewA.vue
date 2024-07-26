<template>
  <div>
    <ChildernSlotA>
        <div>
            <h1>你好</h1>
            <div>我是div</div>
            <a href="hhtp://www.baidu.com">百度</a>
        </div>
    </ChildernSlotA>
  </div>
</template>

<script setup>
    import {ref} from 'vue'
    import ChildernSlotA from '@/components/ChildernSlotA.vue';

    const myName1 = ref('name1')
    const myName2 = ref('name2')
</script>

<style>

</style>