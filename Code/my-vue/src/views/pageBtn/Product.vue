<template>
    <div>
        <!-- 表格里的数据 -->
        <table border="1" cellspacing="0" >
            <tr class="Tr">
                <td>商品编号</td>
                <td>商品名称</td>
                <td>商品价格</td>
            </tr>
            <tr v-for="(item,index) in s.data" :key="index">
                <td>{{item.id}}</td>
                <td>{{item.name}}</td>
                <td>{{item.price}}</td>
            </tr>
        </table>
        <!-- 显示页数的按钮 -->
     <!-- <div >
        <div @click="down" class="up-down">上一页</div>
        <Btn :size="pageSize"></Btn>
        <div @click="up" class="up-down">下一页</div> -->
        <!-- 跳转到：<input type="text" on-model="page">页 -->
        <!-- <div @click="go" class="up-down">Go</div>
    </div> -->
        <button @click="btnsx(0)">上一页</button>
        <btn class="Btn-st" v-for="(item,index) in s.list.btncount" :key="index"
        :size="index" @click="clicknext(index)" :class="{'addclass':s.list.addclass==index}"></btn>
        <button @click="btnsx(1)">下一页</button>
        跳转到：<input type="text" v-model="page" />页
        <button @click="go" >Go</button>
    </div>
</template>

<script setup>
    import Btn from '@/components/Btn.vue';
    import {ref,reactive,onMounted,toRefs} from 'vue';
    // const pageSize=ref(4)
    // const objs = ref([
    //     1,2,3,4,5,6,7,8,9,10
    // ])
    // const Did = 1;
    // const Dname = 1;
    // const Dprice = 198;
    // const page = ref(1)
// -----------------------------------------
    onMounted(()=>{
        createfenye(0,10)
    })
    const s = reactive({sql:[],data:[],list:{}})
    const nums = ref(1)
    for(let i=0;i<100;i++){
        s.sql.push({
            id:i+1,
            name:`桃子${i+1}`,
            price:`${(i+100)*2}`
        })
    }
    s.list.total=s.sql.length
    s.list.dangqian=0
    s.list.pagesize=10
    s.list.btncount=s.list.total / s.list.pagesize
    s.list.addclass=0

    const createfenye=(i1,i2)=>{
        s.data=[]
        for(let i=i1;i<i2;i++){
            s.data.push(s.sql[i])
        }
    }

    const clicknext =(i)=>{
        s.list.dangqian=i
        s.list.addclass=i
        createfenye(((i+1)*10-10),((i+1)*10))
    }

    const btnsx = (i) => {
        //console.log(i)
        if(i == 0 && s.list.dangqian >=1){
            createfenye(((s.list.dangqian-1)*10),((s.list.dangqian)*10))
            s.list.dangqian--
           // console.log(s.list.dangqian)
            s.list.addclass--
        }else if(i == 1 && s.list.dangqian <=8){
            createfenye(((s.list.dangqian+1)*10),((s.list.dangqian+2)*10))
            s.list.dangqian++
           // console.log(s.list.dangqian)
            s.list.addclass++
        }
    }

    const page = ref('')
    const go = () => {
        //console.log("go触发了,page.value=",page.value)
        if(page.value>=1 &&page.value<=10){
            createfenye((page.value-1)*10,(page.value)*10)
            s.list.dangqian=page.value-1
            s.list.addclass=page.value-1
            page.value=''
        }else{
            console.log(`请正确输入页码`)
        }
    }



// ----------------------------------------------------


    // const up = ()=>{
    //     pageSize.value++;
    // }
    // const down = ()=>{
    //     pageSize.value--;
    // }
    // const Go = ()=>{
    //     pageSize.value=page.value;
    // }
</script>

<style>
    .Btn-st{
        margin:5px;
        cursor:pointer;
    }
    .addclass{
        background-color: lightcoral;
        color:#fff;
    }
</style>