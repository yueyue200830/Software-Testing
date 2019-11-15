import { mount, createLocalVue } from '@vue/test-utils'
import App from '@/App.vue'
import axios from 'axios'
import moxios from 'moxios'
import ElementUI from 'element-ui'
import { equal } from 'assert'

const localVue = createLocalVue();

// 正常安装插件
localVue.use(ElementUI);
localVue.prototype.$http = axios;

describe('App.vue', () => {
  let wrapper;

  beforeEach(function () {
    moxios.install();
    wrapper = mount(App, {localVue});
  });

  afterEach(function () {
    moxios.uninstall();
  });

  it('test created request', () => {

    moxios.wait(() => {
      let request = moxios.requests.mostRecent();
      request.respondWith({
        status: 200,
        response: {
          comments: [[{
            id: 1,
            comment: 'hello',
            user: 'Bob',
            time: "Thu Oct 17 03:34:54 CST 2019"
          }]]
        }
      }).then(function () {
        expect(wrapper.find('user')).toBe(true);
        equal(wrapper.findAll('user').at(0).text(), 'Bob');
        equal(wrapper.findAll('id').at(0).text(), 1);
        equal(wrapper.findAll('comment').at(0).text(), 'hello');
      })
    })

  });

  it('renders the correct markup', () => {
    expect(wrapper.html()).toContain('Timeline');
  });

  it('has button', () => {
    expect(wrapper.contains('button.refresh')).toBe(true);
    expect(wrapper.contains('button.load-more')).toBe(true);
  });
});
