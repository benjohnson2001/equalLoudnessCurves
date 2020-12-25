public class DataPoint {

   public Double frequencyValue;
   public Double dbValue;

   public DataPoint(Double frequencyValue, Double dbValue) {
      this.frequencyValue = frequencyValue;
      this.dbValue = dbValue;
   }

   public Double getFrequencyValue() {
      return frequencyValue;
   }

   public Double getDbValue() {
      return dbValue;
   }
}
