import { readonly } from 'vue'
import UserModule from './users'
import GlobalModule from './global'

export default readonly({
  User: UserModule,
  Global: GlobalModule
})
