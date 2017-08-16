const moment = require('moment');

class CompteRenduForm{

    constructor(MedocService, CrenduService, $location){
        this.CrenduService = CrenduService;
        this.MedocService = MedocService.findAllMedoc()
        .then(medicaments => {
        this.medicaments = medicaments;
        this.$location = $location;
        console.log('liste medoc', this.medicaments)
        })

        this.test = "ok";
    }

    saveCr(form, crendu) {
       if (form.$invalid) return;
       this.crendu  = crendu;
       var timestamp = Date.parse(this.crendu.date);  
       var date = moment(this.  crendu.date).format('YYYY-MM-DD');
       console.log('date 1', timestamp, date)
       this.crendu.date = date;
        console.log('date final', this.crendu.date)
       console.log('crendu', this.crendu)
       this.CrenduService.saveCrendu(this.crendu)
       .then(() =>  this.$location.path('/cr'));
                    
    }
}

export const CrForm = {
    controller : CompteRenduForm,
    template : require('./crform.html')
}