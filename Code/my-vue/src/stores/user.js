import {defineStore} from 'pinia'
import { ref,computed } from 'vue'

export const useUserStore = defineStore(
    // id
    'user',
    // state（定义）、getters（获取）、actions（修改）
    () => {
        // state
        const count = ref(1)
        const data = ref(0)
        // getters
        const getCount = computed(()=>{
            return count.value;
        })
        //actions
        const reviseCount = (num) => {
            count.value=num;
        }
        const addCount = (num) => {
            count.value+=num;
            data.value+=num;
        }
        // 模拟异步
        const asyncMethod = (num)=>{
            return new Promise((resolve)=>{
                setTimeout(() => {
                    count.value-=num;
                    if(count.value <= 0){
                        count.value=0
                    }
                    resolve(count.value)
                }, 2000);
            })
        }
        // 异步操作（减法）,async标识符表示函数内部存在异步操作，await和async配合使用，await用来等待promise结果
        const subCount = async(num) => {
            const res = await asyncMethod(num)
            console.log(res)
        }

        return{
            data,
            count,
            getCount,
            subCount,
            addCount
        }
    },
    // 持久化
    {
        persist:{
            // 开启持久化
            enabled:true,
            // 策略
            strategies:[
                {
                    //持久化key名称
                    key:'user-counter',
                    // 存储方式：localStorage或者sessionStorage
                    storage:localStorage,
                    // 指定state中哪些数据需要被持久化，[]表示不持久化任何状态，
                    // undefined或null表示持久化整个state
                    paths: ['data']
            
                }
            ]
        }
    }
)