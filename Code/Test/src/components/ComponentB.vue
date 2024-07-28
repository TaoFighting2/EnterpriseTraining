<template>
  <button type="button" @click="send">发送</button>
</template>

<script setup>
import {ref,defineEmits} from 'vue';
const myEmits = defineEmits(['ClickB'])
const send = ()=>{
    myEmits('ClickB',"success")
}
</script>

<style>

</style>