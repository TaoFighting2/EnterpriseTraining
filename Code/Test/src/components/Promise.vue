<template>
  
</template>

<script setup>
    // const myPromise = new Promise((resolve,reject)=>{
    //     setTimeout(()=>{
    //         const random=Math.random()
    //         console.log(`random = ${random}`)
    //         if(random>0.5){
    //             resolve('成功')
    //         }else{
    //             reject('失败')
    //         }
    //     },1000)
    // })
    // myPromise.then((res)=>{
    //     console.log(`output-->res `,res)
    // }).catch((err)=>{
    //     console.log(`output-->err `,err)
    // })

    const getInfo = (uid)=>{
        return new Promise((resolve,reject)=>{
            setTimeout((uid)=>{
                const random = Math.random()
                console.log(`random = ${random}`)
                if(random>0.5){
                    resolve({id:uid,name:"TaoFighting2"})
                }else{
                    reject(`请正确输入id`)
                }
            },2000)
        })
    }
    getInfo(`001`).then((res)=>{
        console.log(`output-->res `,res)
    }).catch((err)=>{
        console.log(`output-->err `,err)
    })
</script>

<style>

</style>