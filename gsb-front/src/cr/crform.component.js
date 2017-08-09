class CompteRenduForm{

    constructor(MedocService, CrenduService){
        this.CrenduService = CrenduService;
        this.MedocService = MedocService.findAllMedoc()
        .then(medicaments => {
        this.medicaments = medicaments;
        console.log('liste medoc', this.medicaments)
        })

        this.test = "ok";
    }

    saveCr(form, crendu) {
       if (form.$invalid) return;
       this.crendu  = crendu;
       console.log('crendu', this.crendu)
       this.CrenduService.saveCrendu(this.crendu)
       .then(() => this.$location.path('/cr'));
    }
}

export const CrForm = {
    controller : CompteRenduForm,
    template : require('./crform.html')
}