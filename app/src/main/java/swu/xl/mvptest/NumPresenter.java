package swu.xl.mvptest;

public class NumPresenter implements NumModel.ModelCallback,IPresent {
    private NumModel numModel;
    private IView iView;

    public NumPresenter(IView iView) {
        //持有IView对象
        this.iView = iView;
        //初始化NumModel对象
        numModel = new NumModel();
    }

    //ModelCallback成功回调的接口
    @Override
    public void onSuccess(int num) {
        iView.updateUI(num + "");
    }

    //ModelCallback失败回调的接口
    @Override
    public void onFailed(int num) {
        iView.updateUI("");
    }

    //IPresent接口的方法，来自View层的调用
    @Override
    public void add() {
        numModel.add(this);
    }
}
