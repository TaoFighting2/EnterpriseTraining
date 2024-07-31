<template>
    <button @click="yibu">异步</button>
    <button @click="diyu">地域回调</button>
    <button @click="btn">Promise</button>
</template>


<script setup>
    import {ref,} from 'vue'
    // 异步
    const yibu = ()=>{
        setTimeout(()=>{
            console.log("执行了回调函数。")
        },3000)
        console.log("123456")
    }
    // 回调地域
    const diyu = ()=>{
        setTimeout(()=>{
            console.log("123")
            setTimeout(()=>{
                console.log('456')
                setTimeout(()=>{
                    console.log('789')
                },3000)
            },3000)
        },3000)
    }
    const btn = ()=>{
        /*
        promise的状态不受外界的影响 （3种）
        pending[待定]初始状态
        fulfilled[实现]操作成功
        rejected[被否决]操作失败
        */
        const myPromise = new Promise((resolve,reject)=>{
            //resolve是拿结果的，reject是拿错误信息的
            setTimeout(()=>{
                // 获取随机值
                const random =Math.random()
                if(random > 0.5){
                    resolve('成功')
                }else{
                    reject('失败')
                }
            },3000)
        })
        // res的值为resolve函数的实参值
        // err的值为reject函数的实参值
        myPromise.then((res)=>{
            console.log(`output-->res`,res)
        }).catch((err)=>{
            console.log(`output-->res`,err)
        })
    }

    // const getUserInfo = (userId) => {
    //     return new Promise((resolve,reject)=>[
    //         setTimeout(()=>{
    //             const random = Math.random()
    //             if(random>0.5){
    //                 const user = {id:userId,name:'jack',age:30}
    //                 resolve(user)
    //             }
    //             else{
    //                 reject('用户信息不存在')
    //             }
    //         },3000)
    //     ])
    // }
    // getUserInfo('001').then((res)=>{
    //     console.log(`output-->res`,res)
    // }).catch((err)=>{
    //     console.log(`output-->err`,err)
    // })

    // Promise自动化管理
    // 第一种
    // const myPromise1 = Promise.resolve('success')
    // const myPromise2 = Promise.reject('fail')
    // myPromise1.then((res)=>{
    //     console.log(`output-->res`,res)
    // })
    // myPromise2.catch((err)=>{
    //     console.log(`output-->err`,err)
    // })

    // 第二种
    const asyncFn = () => {
        return new Promise((resolve,reject)=>{
            setTimeout(()=>{
                const random = Math.random()
                if(random>0.5){
                    console.log(`random=`,random)
                    resolve('success')
                }
                else{
                    reject('fail')
                }
            },2000)
        })
    }
    Promise.resolve(asyncFn()).then((value)=>{
        console.log(`异步操作执行成功`,value)
    }).catch((error)=>{
        console.log(`异步操作执行失败`,error)
    })

    // promise操作的链式操作
    const my1 = (()=>{
        return new Promise((resolve,reject)=>{
            setTimeout(()=>{
                const random = Math.random()
                if(random>-1){
                    console.log(`random=`,random)
                    resolve('my1success')
                }
                else{
                    reject('my1fail')
                }
            },2000)
        })
    })
    const my2 = (()=>{
        return new Promise((resolve,reject)=>{
            setTimeout(()=>{
                const random = Math.random()
                if(random>0.2){
                    // console.log(`random=`,random)
                    resolve('my2success')
                }
                else{
                    reject('my2fail')
                }
            },2000)
        })
    })
    const my3 = (()=>{
        return new Promise((resolve,reject)=>{
            setTimeout(()=>{
                const random = Math.random()
                if(random>0.5){
                    // console.log(`random=`,random)
                    resolve('my3success')
                }
                else{
                    reject('my3fail')
                }
            },2000)
        })
    })

    // 有错就只执行一个catch错误回调，成功就以数组的形式打印
    // 所有的都会走完，最后返回错误的结果
    // Promise.all([my1(),my2(),my3()]).then((res)=>{
    //     console.log(`res=`,res)
    // }).catch((err)=>{
    //     console.log(`err=`,err)
    // })

    // then返回一个新的Promise实例，所有它可以链式调用
    // 如果返回新的Promise，那么下一级.then()会在新的Promise状态改变之后执行
    // (my1().then((res1)=>{
    //     console.log(`output-->res1`,res1)
    //     // 返回promise对象
    //     return my2()
    // }).catch((err1)=>{
    //     console.log(`output-->err1`,err1)
    // })).then((res2)=>{
    //     console.log(`output-->res2`,res2)
    //     // return my3()
    // }).catch((err2)=>{
    //     console.log(`output-->err2`,err2)
    // })
    // .then((res3)=>{
    //     console.log(`output-->res3`,res3)
    // }).catch((err3)=>{
    //     console.log(`output-->err3`,err3)
    // })

    // 只有一个catch，链条中所有Promise对象由一个reject被执行，那么就直接执行最后的catch回调
    // my1().then((res1)=>{
    //     console.log(`output-->res1`,res1)
    //     // 返回promise对象
    //     return my2()
    // }).then((res2)=>{
    //     console.log(`output-->res2`,res2)
    //     return my3()
    // }).then((res3)=>{
    //     console.log(`output-->res3`,res3)
    // }).catch((err)=>{
    //     console.log(`output-->err`,err)
    // })

    // 同步的中断
    const my4 = (()=>{
        return new Promise((resolve,reject)=>{
            setTimeout(()=>{
                const random = Math.random()
                console.log(`random=`,random)
                if(random>0.5){
                    // console.log(`random=`,random)
                    resolve('my4-success')
                }
                else{
                    reject('my4-fail')
                }
            },2000)
            // throw new Error("The Promise was...")
            reject(new Error("The Promise was...123"))
        })
    })
    // my4().then((res4)=>{
    //     console.log(`output-->res4`,res4)
    // }).catch((err4)=>{
    //     // message是Error的错误信息
    //     console.log(err4.message)
    // })

    // Promise封装异步请求，中断操作
    const my5 = (()=>{
        return new Promise((resolve,reject)=>{
            setTimeout(()=>{
                const random = Math.random()
                console.log(`random=`,random)
                if(random>0.5){
                    resolve('my5-success')
                }
                else{
                    reject('my5-fail')
                }
            },2000)

        })
    })

    const timeOut = (p,timeout = 2000) => {
        const wait = new Promise((resolve,reject)=>{
            setTimeout(()=>{
                reject('请求超时')
            },timeout)
        })
        return Promise.race([p,wait])
    }

    // timeOut(my5()).then((res5)=>{
    timeOut(my5(),1000).then((res5)=>{
        console.log(`output-->res5`,res5)
    }).catch((err5)=>{
        console.log(`output-->err5`,err5)
    })

    // let a = axios.get("http://xxxa")

    // allSettled会返回所有的结果
    // Promise.allSettled([a,b,c,d]).then()
</script>

<style>

</style>