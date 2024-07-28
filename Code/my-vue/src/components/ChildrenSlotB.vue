<template>
    <div style="color:purple;background-color: lightcoral;">
        <!-- slot表示插槽，作用占位，内容由父组件传入 -->
        <!-- 具名插槽 -->
        <slot name="header"></slot>
        <!-- 默认的插槽 -->
        <slot></slot>
        <!-- 具名插槽 -->
        <slot name="footer"></slot>
    </div>
</template>
  