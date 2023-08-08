package ModelElements;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Flash {
    Point3D location;
    Angle3D angle;
    Color color;
    float power;

    public void Rotate(Angle3D grad) {
    }

    public void Move(Point3D cm) {
    }
}
