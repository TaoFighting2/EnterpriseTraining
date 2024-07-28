<template>
    <div>
        <slot name="header" :header="[1,'作用域插槽',3]"></slot>
        <br>
        <hr>
        <slot></slot>
        <br>
        <hr>
        <slot name="footer"></slot>
    </div>
    
</template>

<script setup>
import {ref} from 'vue'
// const arr = 
</script>

<style>

</style>