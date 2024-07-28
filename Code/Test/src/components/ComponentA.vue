<template>
    <div>
        <h1>父传子结果显示界面</h1>
        <div>
            <ul>
                <li v-for="(i,index) in props.item" :key="index">
                    {{ i }}
                </li>
            </ul>
        </div>
    </div>

    
</template>

<script setup>
import {ref,reactive} from 'vue'
import { defineProps } from 'vue';
const props = defineProps(['item'])
console.log("数据传过来了",props.item)
</script>

<style>

</style>