<template>
    <div>
        <h1>{{ message }}</h1>
        <table border="1" cellpadding="0">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>邮箱</th>
            </tr>
            <tr v-for="(item,id) in data" :key="id">
                <td>{{ item.id }}</td>
                <td>{{ item.name }}</td>
                <td>{{ item.age }}</td>
                <td>{{ item.email }}</td>
            </tr>
        </table>
        <button type="button" @click="axiosGet1">axios请求1(get)</button>
        <button type="button" @click="axiosGet2">axios请求2(get)</button>
        <button type="button" @click="axiosPost1">axios请求1(post)</button>
        <button type="button" @click="axiosPost2">axios请求2(post)</button>
        <button type="button" @click="axiosPost3">axios请求3(post)</button>

    </div>
</template>

<script setup>
    import {ref,reactive} from 'vue';
    import axios from 'axios';
    import qs from 'qs';

    const message = ref('axios请求')

    const data = ref([
        {
            "id":1001,
            "name":"张三",
            "age":21,
            "email":"166@qq.com"
        },
        {
            "id":1002,
            "name":"李四",
            "age":20,
            "email":"66@qq.com"
        },
        {
            "id":1003,
            "name":"王五",
            "age":19,
            "email":"16@qq.com"
        }
    ])

    const axiosGet1 = ()=>{
        axios({
            // url请求地址
            url: "http://rap2api.taobao.org/app/mock/238982/students",
            // method 请求方式
            mothed:"get",
            // params表示get请求的参数，值是用对象形式

            params:{p1:'A',p2:'B'}
        }).then((response)=>{
            console.log(`output-->response `,response)
            if(response.status == 200){
                data.value = response.data.students
            }else{
                alert(`返回失败`)
            }
        }).catch((e)=>{
            console.log(`output-->e `,e)
        })
        console.log(`代码打印在axios之后`)
    }

    const axiosGet2 = ()=>{
        // 调用axios的get函数，发出get请求
        const url = "http://rap2api.taobao.org/app/mock/238982/students"
        const params = {p1:'A',p2:'B'}
        // get函数，第一个参数是 请求的URL，第二个参数是一个对象，其中，有params属性
        axios.get(url,{params}).then((response)=>{
            console.log(`output-->response `,response)
            if(response.status == 200){
                data.value = response.data.students
            }else{
                alert(`服务器数据有问题`)
            }
        }).catch((e)=>{
            console.log(`output-->e `,e)
        })
    }
    // post默认是异步请求
    const axiosPost1 = () => {
        axios({
            url:`http://rap2api.taobao.org/app/mock/285595/post-students`,
            mothed:"post",
            data:{p1:'A',p2:'B'}
        }).then((response)=>{
            console.log(`output-->response `,response)
            if(response.status == 200){
                data.value = response.data.students
            }else{
                alert(`服务器数据有问题`)
            }
        }).catch((e)=>{
            console.log(`output-->e `,e)
        })
    }
    const axiosPost2 = () => {
        const dataObj = {p1:'A',p2:'B'}
        const data = qs.stringify(dataObj)
        console.log(`data = `,data)
        axios({
            url:`http://rap2api.taobao.org/app/mock/285595/post-students`,
            mothed:"post",
            data,//ES6的用法
            // 修改请求头的类型
            headers:{'content-Type':'application/x-www-form-urlencoded'}
        }).then((response)=>{
            console.log(`output-->response `,response)
            if(response.status == 200){
                data.value = response.data.students
            }else{
                alert(`服务器数据有问题`)
            }
        }).catch((e)=>{
            console.log(`output-->e `,e)
        })
    }

    const axiosPost3 = () => {
        const data = qs.stringify({p1:'A',p2:'B'})
        console.log(`data = `,data)
        const url = `http://rap2api.taobao.org/app/mock/285595/post-students`
        axios.post(url,data,{
            // 修改请求头的类型
            // header:{'content-Type':'application/x-www-form-urlencoded'}
        }).then((response)=>{
            console.log(`output-->response `,response)
            if(response.status == 200){
                data.value = response.data.students
                // axios().then(()=>{

                // }).catch()
            }else{
                alert(`服务器数据有问题`)
            }
        }).catch((e)=>{
            console.log(`output-->e `,e)
        })
    }

</script>

<style>

</style>