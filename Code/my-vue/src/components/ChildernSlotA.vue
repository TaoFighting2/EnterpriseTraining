<template>
  <div>
    <!-- slot表示插槽，作用占位，内容由父组件传入 -->
    <!-- 默认插槽 -->
  <div style="color:red;background-color:aliceblue">
        <slot></slot>
    </div>
    <h1>wszzj</h1>
    <slot></slot>
    <h1>wszzj</h1>
    <slot></slot>

  </div>
</template>
