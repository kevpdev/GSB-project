class CompteRendu{

    constructor(CrenduService){
        this.CrenduService = CrenduService.findAll()
        .then(crendus => {
            this.crendus = crendus;
            console.log('liste crendus', this.crendus)
        })
        this.showAddForm = false;
        console.log(this.showAddForm)
    }

    showAddFormul(){
        this.showAddForm = true;
    }
    hideAddForm(){
        this.showAddForm = false;
    }

}

export const Cr = {
    controller : CompteRendu,
    template : require('./cr.html')
}