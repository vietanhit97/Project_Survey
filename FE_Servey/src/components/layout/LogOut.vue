<template>
    <div class="dropdown bg-none ">
        <button class="btn btn-secondary dropdown-toggle border-0 float-right" style="background:none;float:right"
            type="button" id="triggerId" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa-solid fa-user fa-2x"></i>
        </button>
        <div class="dropdown-menu" aria-labelledby="triggerId">
            <a class="dropdown-item" href="#">{{nameUser}}</a>
            <button class="dropdown-item" @click="loguot()">Đăng xuất</button>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'LogOut',
    data() {
        return {
            nameUser: ''
        }
    },
    methods: {
        loguot() {
            axios.get('http://192.168.120.180:8081/auth/logout', {
                headers: {
                    'Authorization': 'Bearer ' + sessionStorage.getItem('token')
                }
            })
                .then(
                    sessionStorage.clear(),
                    alert("Đăng xuất thành công !"),
                    this.$router.push({ name: 'login' })
                )
                .catch(error => {
                    console.error(error);
                });
        }
    },
    mounted() {
        const user = JSON.parse(sessionStorage.getItem('user'));
        this.nameUser = user.userName

    }
}
</script>

<style></style>