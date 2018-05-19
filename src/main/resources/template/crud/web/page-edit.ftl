<template>
    <el-form :model="model" :rules="rules" label-width="80px" ref="form" class="c-form">
        <el-form-item label="姓名" prop="name">
            <el-input v-model="model.name"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit" :loading="loading">保存</el-button>
            <el-button @click="$router.back()">取消</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
import { save,getById,getRoles,getAllRoles } from 'src/service/${module_name}/${name}'

export default {
    data() {
        return {
            loading: false,
            model:{},
            rules: {
                name: [
                    { required: true, message: '请填写姓名', trigger: 'blur' },
                ],
            }
        }
    },
    created(){
        this.initData();
    },
    methods: {
        async initData(){
            const id = this.model.id = this.$route.params.id;
            if(id){
                this.model = await getById(id)
            }
        },
        onSubmit() {
            this.$refs.form.validate(async (valid) => {
                if (valid) {
                    try {
                        this.loading = true;
                        await save(this.model);
                        this.$notify.success(this.model.id ? '修改':'新增' + '成功');
                        this.$router.back();
                    } catch (e) {
                        this.$notify.error(e.message);
                    } finally {
                        this.loading = false;
                    }
                }
            });
        },
    }
}
</script>