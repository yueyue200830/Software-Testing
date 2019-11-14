import { mount } from '@vue/test-utils'
import App from './App';

describe('App', () => {
    // 现在挂载组件，你便得到了这个包裹器
    const wrapper = mount(App);

    it('renders the correct markup', () => {
        expect(wrapper.html()).toContain('<span class="count">0</span>')
    });

    // 也便于检查已存在的元素
    // it('has a button', () => {
    //     expect(wrapper.contains('button')).toBe(true)
    // })
});