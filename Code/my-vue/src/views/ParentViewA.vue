<template>
  <div>
    <ChildernSlotA>
        <div>
            <h1>你好</h1>
            <div>我是div</div>
            <a href="hhtp://www.baidu.com">百度</a>
        </div>
        <template #footer>
          <h1>TaoFighting</h1>
        </template>
    </ChildernSlotA>
    <br><hr>
    <ChildrenSlotB>
      <!-- template在元素里是不显示的， -->

      <!-- v-slot:插槽名称（简写方式）使用指定名称的插槽 -->
      <template v-slot:header>
        <h1>我是head</h1>
      </template>

      <!-- <div><h1>我是中间部分</h1></div> -->

      <!-- <div><h1>我是中间部分</h1></div> -->
      <!-- #插槽名称（简写方式）使用指定名称的插槽 -->
      <template #footer>
        <h1>我是footer</h1>
      </template>

      <!-- #default默认插槽的设置，忽略位置的影响 -->
      <template #default>
        <div><h1>我是中间</h1></div>
      </template>
    </ChildrenSlotB>
    <br><hr>
    <ChildrenSlotC>
      <!-- 子组件插件名称=自定义名称 -->
      <!-- <template #header="scopeH"> -->
      <template #header="scope">
        <!-- 自定义名称：子组件插槽定义的作用域数据名称 -->
        <h2 v-for="(num,index) in scope.headerData" :key="index">
          {{ num }}
        </h2>
      </template>
      <!-- #default="{子组件插槽定义的作用域数据名称}" -->
      <template #default="{bodyData:aa}">
        <h2>{{ aa.userName }}</h2>
        <h2>{{ aa.password }}</h2>
      </template>
      <!-- footer -->
      <template #footer="{footerData}">
        <h2 v-for="(item,index) in footerData" :key="index">{{ item }}</h2>
      </template>
    </ChildrenSlotC>
    <ChildrenSlotD>
      <!-- 动态的插槽名称 -->
      <!-- 插槽名称可以使用变量[变量名称]，变量值即对应子组件中slot的名字 -->
      <template v-slot:[myName1]>
        <h1>我是name1</h1>
      </template>
      <template #[myName2]="{footerData}">
        <h2 v-for="(item,index) in footerData" :key="index">{{ item }}</h2>
        <h1>我是name2</h1>
      </template>
    </ChildrenSlotD>
  </div>
</template>

<script setup>
    import {ref} from 'vue'
    import ChildernSlotA from '@/components/ChildernSlotA.vue';
    import ChildrenSlotB from '@/components/ChildrenSlotB.vue';
    import ChildrenSlotC from '@/components/ChildrenSlotC.vue';
    import ChildrenSlotD from '@/components/ChildrenSlotD.vue';

    const myName1 = ref('name1')
    const myName2 = ref('name2')
    
    //定时器
    setTimeout(()=>{
      myName1.value="name2"
      myName2.value="name1"
    },5000)

</script>

<style>

</style>