<template>
    <header class="">
        <div class="row">
            <div class="col-sm-4">
                <a href="https://trithucmoi.co/">
                    <img src="https://trithucmoi.co/app_assets/images/ttm_logo.png" alt="">
                </a>
            </div>
            <div class="col-sm-4 ">
                <nav class="navbar navbar-expand-sm navbar-light ">
                    <div class="container">
                        <div class="collapse navbar-collapse " id="collapsibleNavId">
                            <ul class="navbar-nav mx-auto mt-2 mt-lg-0 ">
                                <li class="nav-item ">
                                    <router-link to="/surveys-admin" :key="$route.fullPath" exact class="nav-link"
                                        :class="{ 'active': $route.path === '/surveys-admin' }">
                                        Khảo sát
                                    </router-link>
                                </li>
                                <li class="nav-item">
                                    <router-link to="/list-employee" :key="$route.fullPath" exact class="nav-link"
                                        :class="{ 'active': $route.path === '/list-employee' }">
                                        Thành Viên
                                    </router-link>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="col-sm-4 ">
                <LogOut/>
            </div>
        </div>
    </header>
</template>
<script>
import LogOut from './LogOut.vue'
export default {
    name: 'PageHearder',
    components:{
        LogOut
    }
}
</script>
<style>
header {
    left: 40px;
    top: 0px;
    background: #E3C2B9;
    padding: 20px;
}
header .active{
    color: cornflowerblue!important;
    border-bottom: 1px solid cornflowerblue;
}
</style>