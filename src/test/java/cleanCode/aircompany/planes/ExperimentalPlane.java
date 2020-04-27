package cleanCode.aircompany.planes;

import cleanCode.aircompany.models.ClassificationLevel;
import cleanCode.aircompany.models.ExperimentalType;
import java.util.Objects;

public class ExperimentalPlane extends Plane {
    private ExperimentalType experimentalType;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalType experimentalType, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = experimentalType;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
        this.classificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ExperimentalPlane)) return false;
        if (!super.equals(object)) return false;
        ExperimentalPlane that = (ExperimentalPlane) object;
        return experimentalType.equals(that.experimentalType) &&
                classificationLevel.equals(that.classificationLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), experimentalType, classificationLevel);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                "experimentalType=" + experimentalType +
                ", classificationLevel=" + classificationLevel +
                '}');
    }
}
