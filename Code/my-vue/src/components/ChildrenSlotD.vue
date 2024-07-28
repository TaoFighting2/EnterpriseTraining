<template>
    <br><hr>
    <slot name="name1"></slot>
    <slot name="name2" :footerData="arr"></slot>
</template>
<script setup>
    import {reactive,defineProps} from 'vue'
    const arr = reactive(['A','B','C'])
</script>