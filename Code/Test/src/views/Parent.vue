<template>
     <div>
        <ChildA>
            <div>
                <div>
                    <h1>默认插槽1</h1>
                </div>
                <div>
                    <h1>默认插槽2</h1>
                </div>
            </div>
            <template v-slot:header="scope">
                <h1>具名插槽</h1>
                <h1>{{ scope.header[1] }}</h1>
            </template>
            <template v-slot:[name]>
                <h1>具名插槽</h1>
            </template>
        </ChildA>
        <button type="button" @click="revise" >修改</button>

    </div>
</template>

<script setup>
    import ChildA from '@/components/ChildA.vue';
    import {ref} from 'vue'
    const name = ref("footer")
    const revise = () => {
        name.value="header"
    }
</script>

<style>

</style>