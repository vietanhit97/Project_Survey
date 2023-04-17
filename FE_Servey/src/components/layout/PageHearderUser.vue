<template>
    <header>
        <div class="row">
            <div class="col-sm-4">
                <a href="https://trithucmoi.co/">
                    <img src="https://trithucmoi.co/app_assets/images/ttm_logo.png" alt="">
                </a>
            </div>
            <div class="col-sm-4 ">
                <nav class="navbar navbar-expand-sm navbar-light ">
                    <div class="container">
                        <div class="collapse navbar-collapse" id="collapsibleNavId">
                            <ul class="navbar-nav mx-auto mt-2 mt-lg-0">
                                <router-link to="/surveys-user" exact class="nav-link"
                                    :class="{ 'active': $route.path === '/surveys-user' }">
                                    Khảo sát
                                </router-link>
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
    name: 'PageHearderUser',
    components:{
        LogOut
    }
}
</script>
<style></style>