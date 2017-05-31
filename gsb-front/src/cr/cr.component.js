class CompteRendu{

    constructor(CrenduService){
        this.CrenduService = CrenduService.findAll()
        .then(crendus => {
            this.crendus = crendus;
            console.log('liste crendus', this.crendus)
        })
    }

}

export const Cr = {
    controller : CompteRendu,
    template : require('./cr.html')
}