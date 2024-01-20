/** Класс, описывающий квадрат. Является наследником класса Rectangle */
public class Square extends Rectangle {
    /**
     * Переопределенный метод, который задает стороны квадрата
     * @param side - стороны (так как у квадрата все стороны равны, используется только одно значение)
     * @param unusdParameter - неиспользуемый параметр (так как в родительском классе метод принимает два параметра, здесь должно быть также)
     */
    @Override
    public void setSide(int side, int unusedParameter) {
        super.width = side;
        super.height = side;
    }
}