import { createApp } from 'vue'
import App from './App.vue'
import playground from './views/playground/playgroundView.vue'
import { setup } from './utils/boostrap'
import '@/assets/css/fonts.css'
import '@/assets/css/tailwind.css'
import 'animate.css'

setup({
  onProduction: () => {
    createApp(App).mount('#app')
  },
  onDevelopment () {
    createApp(playground).mount('#app')
  }
})
