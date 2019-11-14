import { mount, createLocalVue } from '@vue/test-utils'
import App from '@/App.vue'
// import axios from 'axios'
import mockAxios from '../mocks/axios'
import ElementUI from 'element-ui'

const localVue = createLocalVue();

// 正常安装插件
localVue.use(ElementUI);
// localVue.prototype.$http = axios;
localVue.prototype.$http = mockAxios;

describe('App.vue', () => {

  const wrapper = mount(App, {localVue});

  it('renders the correct markup', () => {
     expect(wrapper.html()).toContain('Timeline')
  });

  it('has button', () => {
    expect(wrapper.contains('button.refresh')).toBe(true);
    expect(wrapper.contains('button.load-more')).toBe(true)
  });
})
