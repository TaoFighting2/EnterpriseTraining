<!-- 父组件访问子组件数据 子传父
        第一步：在子组件中使用emit(事件名，数据)触发自定义事件，事件名自定义
        第二步：父组件在使用了组件的地方监听了组件触发的事件，并在父组件中定义方法，用来获取数据
        总结：
-->
<template>
  
    <div>
        <h2>{{ info }}</h2>
        <button type="button" v-for="item in fenlei" :key="item.id" @click="btnClick(item)">btnClick:{{ item.name }}</button>
    </div>

</template>

<script setup>
    import {ref,reactive,defineEmits} from 'vue'
    const info = ref('子组件A')
    const fenlei = reactive([
        {id:1,name:"家电1"},
        {id:2,name:"家电2"},
        {id:3,name:"家电3"},
    ])
    // 自定义事件可以有多个
    const myEmits = defineEmits(['itemClick'])
    const btnClick = (Value) => {
        //触发自定义事件，附带上一个分类对象
        myEmits('itemClick',Value)
    }
</script>

<style>

</style>